(fn [f & maps]
  (letfn [(step [m1 m2]
            (if (seq m2)
              (let [first-ele-in-m2 (first m2)
                    v-in-m1 (m1 (key first-ele-in-m2))]
                (if v-in-m1
                  (step
                    (assoc m1 (key first-ele-in-m2) (f v-in-m1 (val first-ele-in-m2)))
                    (rest m2))
                  (step
                    (assoc m1 (key first-ele-in-m2) (val first-ele-in-m2))
                    (rest m2))))
              m1))]
    (reduce step maps)))