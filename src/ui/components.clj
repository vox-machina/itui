(ns ui.components
  "Abstract away layout and other Hiccup components.
  Additionally presents the possibility of abstracting away CSS and styling details."
  (:require [ten-d-c.hiccup-server-components.core :refer [reg-component]]))

;;;; Layouts - navbars, cards etc.
;;;; ===========================================================================

;; REVIEW: plug in parameterise styling to support Bootstrap and other options
(reg-component :ui.l/navbar-simple
  (fn [{:keys [link-root nav session style] :or {session nil link-root nil nav {} style nil}} title]
    [:nav.navbar.navbar-expand-md.navbar-light.fixed-top.bg-light
     [:div.container-fluid
      [:a {:class "navbar-brand" :href "/"} title]
      [:button {:class "navbar-toggler" :type "button" :data-toggle "collapse" :data-target "#navbarCollapse" :aria-controls "navbarCollapse" :aria-expanded "false" :aria-label "Toggle navigation"}
       [:span {:class "navbar-toggler-icon"}]]
      [:div {:class "collapse navbar-collapse" :id "navbarCollapse"}]]]))

;; REVIEW: plug in parameterised styling to support Bootstrap and other optoins
(reg-component :ui.l/card
  (fn [{:keys [session link-root style] :or {session nil link-root nil style nil}} title & body]
    [:div.card
     [:div.card-header [:h2 title]]
     [:div.card-body body]]))

;;;; Components - including alerts etc.
;;;; ===========================================================================

(reg-component :ui.c/btn-link
  {:doc "Creates a simple link button of a specified type (e.g. primary, secondary)"}
  (fn [{:keys [type style uri text] :or {style nil type :primary}}] [:a.btn.btn-primary {:href uri :role "button"} text]))

;; REVIEW: strategy for provisoin of mirror-info styling... what is this CSS?
(reg-component :ui.c/alert-info
  {:doc "Creates a simple alert with info styling and provided content."}
  (fn [{:keys [style] :or {style nil}} & content] [:div.alert.alert-info.mirror-info {:role "alert"} content]))

;; REVIEW: strategy for provision of mirror-info styling... what is this CSS?
(reg-component :ui.c/alert-success
  {:doc "Creates a simple alert with success styling and provided content."}
  (fn [{:keys [style] :or {style nil}} & content] [:div.col-lg-9 {:role "main"} [:div.alert.alert-success.mirror-info {:role "alert"} content]]))
