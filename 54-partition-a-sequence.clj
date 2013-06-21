(fn [step coll] (letfn [(func [step coll]
                                      (if (>= (count coll) step)
                                        (cons (take step coll) (func step (drop step coll)))))]
                              (func step coll)))