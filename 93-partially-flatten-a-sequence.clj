(fn [coll]
  (letfn [(step [coll result]
            (if (seq coll)
              (let [first-ele (first coll)]
                (step (next coll)
                  (if (some coll? first-ele)
                    (reduce #(conj %1 %2) result (step first-ele []))
                    (conj result first-ele))))
              result)
            )]
    (step coll [])))