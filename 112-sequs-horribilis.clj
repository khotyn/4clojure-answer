(fn [max-sum coll]
  (letfn [(step [coll current-sum max-sum]
            (if (seq coll)
              (let [head (first coll)]
                (if (coll? head)
                  (let [sub (step head current-sum max-sum)
                        next-sum (+ current-sum (reduce + (flatten sub)))]
                    (if (<= next-sum max-sum)
                      (cons sub (step (next coll) next-sum max-sum))
                      sub))
                  (let [next-sum (+ head current-sum)]
                    (if (<= next-sum max-sum)
                      (cons head (step (next coll) next-sum max-sum))
                      []))))))]
    (step coll 0 max-sum)))