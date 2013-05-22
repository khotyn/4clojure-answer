(fn [triangle]
  (let [r-triangle (reverse triangle)
        triangle-tier (count r-triangle)]
    (reduce
      +
      (apply
        (partial min-key #(apply + %))
        (reduce
          (fn [to from]
            (let [parted-length (reduce * (repeat (- triangle-tier (count from)) 2))
                  parted-to (partition parted-length (quot parted-length 2) to)]
              (mapcat #(map (fn [coll] (cons %1 coll)) %2) from parted-to)))
          (map #(vec [%]) (first r-triangle))
          (rest r-triangle))))))