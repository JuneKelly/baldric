(ns baldric.core
  (:use [seesaw.core])
  (:import org.pushingpixels.substance.api.SubstanceLookAndFeel)
  (:gen-class))


(native!)
(SubstanceLookAndFeel/setSkin "org.pushingpixels.substance.api.skin.MistSilverSkin")


(defn -main [& args]
  (invoke-later
    (->
      (frame
        :title "Baldric v0.0.1"
        :on-close :exit
        :minimum-size [800 :by 600]
        :content (border-panel))
      pack!
      show!)))

