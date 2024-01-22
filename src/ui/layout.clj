(ns ui.layout
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.body-params :refer [body-params]]
            [io.pedestal.http.ring-middlewares :as mw]
            [ring.middleware.session.cookie :as cookie]
            [ring.util.response :refer [response]]
            [ten-d-c.hiccup-server-components.core :refer [->html]]))

(def htm-tors [(body-params) http/html-body])

(def ses-tors [(mw/session {:store (cookie/cookie-store)}) mw/params mw/keyword-params (body-params) http/html-body])

(defn page [session head body & markup] (response (->html [:ux/html5-doc (head) (body session markup)])))