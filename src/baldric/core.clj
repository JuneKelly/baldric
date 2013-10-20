(ns baldric.core
  (:use [seesaw.core])
  (:require [seesaw.util :as su])
  (:import org.pushingpixels.substance.api.SubstanceLookAndFeel)
  (:gen-class))


;; Set look and feel
(native!)
(SubstanceLookAndFeel/setSkin
  "org.pushingpixels.substance.api.skin.MistSilverSkin")


(declare activate)


(def top-panel
  (atom (horizontal-panel :items [(button :text "Menu" :margin (su/to-insets 5))
                                  (text :editable? true)])))


(def demo-app (atom
  (scrollable (text :multi-line? true
                    :text "Welcome to Baldric!"))))


(def main-panel
  (atom (border-panel :hgap 5
                      :vgap 5
                      :north @top-panel
                      :center @demo-app)))


(defn set-content [w]
  (config! main-panel :center (scrollable w)))


(defn load-app [location]
  (do
    (eval (read-string (slurp location)))
    (activate)))


(defn -main [& args]
  (invoke-later
    (->
      (frame
        :title "Baldric v0.0.1"
        :on-close :exit
        :minimum-size [800 :by 600]
        :content @main-panel)
      pack!
      show!))
  (load-app "http://localhost:8000/example.clj"))

