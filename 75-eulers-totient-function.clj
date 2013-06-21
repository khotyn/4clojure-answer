(fn [n]
              (if (= n 1)
                1
                (letfn [(gcd [a b]
                          (let [big (max a b) small (min a b) next-small (mod big small)]
                            (if (zero? next-small)
                              small
                              (gcd small next-small))))]
                  (count (filter #((fn [a b] (= 1 (gcd a b))) n %) (range 1 n))))))
