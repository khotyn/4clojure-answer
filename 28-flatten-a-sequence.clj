(fn [coll]
       (letfn [(my-flatten [coll]
                 (if coll
                   (let
                     [s (seq coll) f (first s)]
                     (concat
                       (if
                         (sequential? f)
                         (my-flatten f)
                         (cons f '()))
                       (my-flatten (next s))))))]
         (my-flatten coll)))
