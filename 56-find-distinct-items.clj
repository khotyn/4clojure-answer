(fn [coll] (letfn [(step [coll, targetColl]
                                 (if (empty? coll)
                                   targetColl
                                   (if
                                     (nil? (some #{(first coll)} targetColl))
                                     (step (next coll) (concat targetColl [(first coll)]))
                                     (step (next coll) targetColl))))]
                         (step coll [])))