(fn [coll]
          (letfn [(comp-seq [coll]
                    (if
                      coll
                      (let
                        [f (first coll)
                         r (next coll)]
                        (if
                          (not (= f (first r)))
                          (cons f (comp-seq r))
                          (comp-seq r)))))]
            (comp-seq coll)))
