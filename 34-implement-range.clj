(fn
          [start end]
          (letfn [(step [start end]
                    (if
                      (< start end)
                      (cons
                        start
                        (step (+ start 1) end))))]
            (step start end)))
