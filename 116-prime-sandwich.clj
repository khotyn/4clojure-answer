(fn [num]
  (letfn [(prime []
            (letfn [(step [coll]
                      (let [head (first coll)]
                        (lazy-seq (cons head (step (filter #(pos? (mod % head)) coll))))))]
              (step (range 2 Long/MAX_VALUE))))
          (balanced-prime []
            (map second (filter #(= (second %) (/ (+ (first %) (last %)) 2)) (partition 3 1 (prime)))))]
    (= num (last (take-while #(<= % num) (balanced-prime))))))