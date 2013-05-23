(fn [s]
  (letfn [(step [ele s]
            (let [n (filter #(= (second ele) (first %)) s)]
              (if (seq n)
                (let [t (map #(vec [(first ele) (second %)]) n)]
                  (cons ele (mapcat #(step % s) t)))
                [ele])))]
    (set (mapcat #(step % s) s))))