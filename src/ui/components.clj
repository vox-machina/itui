(ns ui.components
  (:require [ten-d-c.hiccup-server-components.core :refer [reg-component]]))

(reg-component
 :ux.layouts/navbar-simple
 (fn [{:keys [link-root title nav session]}]
   [:nav.navbar.navbar-expand-md.navbar-light.fixed-top.bg-light
    [:a {:class "navbar-brand" :href "/"} title]
    [:button {:class "navbar-toggler" :type "button" :data-toggle "collapse" :data-target "#navbarCollapse" :aria-controls "navbarCollapse" :aria-expanded "false" :aria-label "Toggle navigation"}
     [:span {:class "navbar-toggler-icon"}]]
    [:div {:class "collapse navbar-collapse" :id "navbarCollapse"}]]))