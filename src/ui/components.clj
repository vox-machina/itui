(ns ui.components
  (:require [ten-d-c.hiccup-server-components.core :refer [reg-component]]))

;;;; Layouts - navbars, cards etc.
;;;; ===========================================================================

(reg-component :ui.l/navbar-simple
 (fn [{:keys [link-root nav session] :or {session nil link-root nil nav {}}} title]
   [:nav.navbar.navbar-expand-md.navbar-light.fixed-top.bg-light
    [:div.container-fluid
     [:a {:class "navbar-brand" :href "/"} title]
     [:button {:class "navbar-toggler" :type "button" :data-toggle "collapse" :data-target "#navbarCollapse" :aria-controls "navbarCollapse" :aria-expanded "false" :aria-label "Toggle navigation"}
      [:span {:class "navbar-toggler-icon"}]]
     [:div {:class "collapse navbar-collapse" :id "navbarCollapse"}]]]))

(reg-component :ui.l/card
 (fn [{:keys [session link-root] :or {session nil link-root nil}} title & body]
   [:div.card
     [:div.card-header [:h2 title]]
    [:div.card-body body]]))

;;;; Components - including alerts etc.
;;;; ===========================================================================

;; REVIEW: strategy for provisoin of mirror-info styling... what is this CSS?
(reg-component :ui.c/alert-info
  {:doc "Creates a simple alert with info styling and provided content."}
  (fn [& content] [:div.alert.alert-info.mirror-info {:role "alert"} content]))

;; REVIEW: strategy for provision of mirror-info styling... what is this CSS?
(reg-component :ui.c/alert-success
  {:doc "Creates a simple alert with success styling and provided content."}
  (fn [& content] [:div.col-lg-9 {:role "main"} [:div.alert.alert-success.mirror-info {:role "alert"} content]]))
