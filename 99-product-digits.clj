(fn [a b]
          (letfn [(step [i]
                    (if (pos? i)
                      (cons (rem i 10) (step (quot i 10)))))]
            (reverse (step (* a b)))))
