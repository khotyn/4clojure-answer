(fn [num-seq]
  (if (seq num-seq)
    (let [sorted-num-seq (sort num-seq)
          partited-num-seq (partition-by
                             #(<= (- (last %) (first %)) 1)
                             (partition 2 1 (concat (cons (first sorted-num-seq) sorted-num-seq) [(last sorted-num-seq)])))]
      (letfn [(step [coll]
                (if (seq coll)
                  (let [ele (first coll)
                        first-group (first ele)]
                    (if (<= (- (last first-group) (first first-group)) 1)
                      (let [flatten-ele (flatten ele)]
                        (cons [(first flatten-ele) (last flatten-ele)] (step (next coll))))
                      (let [uncontinue-ele (apply sorted-set (drop-last (next (flatten ele))))]
                        (if uncontinue-ele
                          (concat (map #(vec [% %]) uncontinue-ele) (step (next coll)))
                          (concat [] (step (next coll)))))))
                  []))]
        (step partited-num-seq)))
    []))