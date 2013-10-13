(ns baldric.core
  (:use [seesaw.core])
  (:require [seesaw.util :as su])
  (:import org.pushingpixels.substance.api.SubstanceLookAndFeel)
  (:gen-class))


;; Set look and feel
(native!)
(SubstanceLookAndFeel/setSkin
  "org.pushingpixels.substance.api.skin.MistSilverSkin")


(defn top-panel []
  (horizontal-panel :items [(button :text "Menu" :margin (su/to-insets 5))
                            (text :editable? true)]))


(defn main-display-area []
  (scrollable (text :multi-line? true
                    :text "Welcome to Baldric!")))


(defn -main [& args]
  (invoke-later
    (->
      (frame
        :title "Baldric v0.0.1"
        :on-close :exit
        :minimum-size [800 :by 600]
        :content (border-panel
                   :vgap 5
                   :hgap 5
                   :north (top-panel)
                   :center (main-display-area)))
      pack!
      show!)))

