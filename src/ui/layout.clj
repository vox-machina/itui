(ns ui.layout
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.body-params :refer [body-params]]
            [io.pedestal.http.ring-middlewares :as mw]
            [ring.middleware.session.cookie :as cookie]
            [ring.util.response :refer [response]]
            [net.cgrand.enlive-html :refer [html-resource]]
            [ten-d-c.hiccup-server-components.core :refer [->html]])
  (:import java.io.StringReader))

(defn- enlive->hiccup
  [el]
  (if-not (string? el)
    (->> (map enlive->hiccup (:content el))
         (concat [(:tag el) (:attrs el)])
         (keep identity)
         vec)
    el))

(defn- html->enlive [html] (first (html-resource (StringReader. html))))

(defn html->hiccup
  "Converts HTML to Hiccup to be used dynamically in programs.
  This is useful when loading static HTML from disk for example."
  [html] (-> html html->enlive enlive->hiccup))

(def htm-tors
  "An interceptor for sessionless HTML generating Pedestal routes."
  [(body-params) http/html-body])


(def ses-tors
  "An interceptor for sessioned HTML generating Pedestal routes where a cookie store session will suffice."
  [(mw/session {:store (cookie/cookie-store)}) mw/params mw/keyword-params (body-params) http/html-body])

(defn page
  "Creates a page template given a session, head, body and variadic forms for content inside body.
  Using hiccup server components provisions for componentisation."
  [session head body & markup] (response (->html [:ux/html5-doc (head) (body session markup)])))
