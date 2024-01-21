(ns ui.components
  (:require [ten-d-c.hiccup-server-components.core :refer [reg-component]]))

(reg-component
 :ui.l/navbar-simple
 (fn [{:keys [link-root nav session] :or {session nil link-root nil nav {}}} title]
   [:nav.navbar.navbar-expand-md.navbar-light.fixed-top.bg-light
    [:div.container-fluid
    [:a {:class "navbar-brand" :href "/"} title]
    [:button {:class "navbar-toggler" :type "button" :data-toggle "collapse" :data-target "#navbarCollapse" :aria-controls "navbarCollapse" :aria-expanded "false" :aria-label "Toggle navigation"}
     [:span {:class "navbar-toggler-icon"}]]
    [:div {:class "collapse navbar-collapse" :id "navbarCollapse"}]]]))

(reg-component
 :ui.l/card
 (fn [{:keys [session link-root] :or {session nil link-root nil}} title & body]
   [:div.card
     [:div.card-header [:h2 title]]
     [:div.card-body body]]))
