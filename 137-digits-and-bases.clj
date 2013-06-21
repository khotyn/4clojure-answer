(fn [num base]
              (letfn [(step [num base]
                        (concat
                          (if (zero? (quot num base)) [] (step (quot num base) base))
                          [(mod num base)]))]
                (step num base)))
