(fn [coll]
  (let [result (conj (empty coll) [1 2] [1 2] [1 3])]
    (if (= 1 (count result))
      :map (if (= 2 (count result))
             :set (if (= [1 3] (first result))
                    :list :vector )))))