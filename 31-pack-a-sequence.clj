(fn
          [coll]
          (letfn
            [(pack-seq [coll]
               (if (not (empty? coll))
                 (cons
                   (take-while
                     #(= % (first coll))
                     coll)
                   (pack-seq (drop-while
                               #(= % (first coll))
                               coll)))))]
            (pack-seq coll)))
