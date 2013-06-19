(fn [dfa]
  (letfn [(get-next-statuses [current-statuses]
            (apply merge (flatten (map
                                    (fn [entry]
                                      (let [ns (get (:transitions dfa) (val entry))]
                                        (if ns (map #(assoc {} (concat (key entry) [(key %)]) (val %)) ns))))
                                    current-statuses))))
          (step [current-statuses]
            (let [next-statuses (get-next-statuses current-statuses)]
              (if next-statuses
                (lazy-cat
                  (map #(apply str (key %)) (filter #((:accepts dfa) (val %)) next-statuses))
                  (step next-statuses)))))]
    (step {[] (:start dfa)})))
