(fn [start end]
  (letfn [(transform [num]
            (if (even? num)
              [(* 2 num) (+ 2 num) (quot num 2)]
              [(* 2 num) (+ 2 num)]))
          (step [current-set end step-count]
            (let [next-set (reduce into #{} (map transform current-set))]
              (if (next-set end)
                (inc step-count)
                (step next-set end (inc step-count)))))]
    (if (= start end)
      1
      (step #{start} end 1))))