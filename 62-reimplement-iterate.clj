(fn [f x]
                  (letfn [(step [f x]
                            (lazy-seq
                              (cons
                                x
                                (step f (f x)))))]
                    (step f x)))
