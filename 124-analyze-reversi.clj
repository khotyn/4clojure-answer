(fn [board piece]
  (letfn [(step [op-piece start gap result]
            (let [next-start (mapv #(+ %1 %2) start gap)
                  next-piece (get-in board next-start)]
              (if (= next-piece op-piece)
                (step op-piece next-start gap (conj result next-start))
                (if (= next-piece 'e)
                  (if (seq result)
                    {next-start (set result)}
                    {})
                  {}))))]
    (apply
      merge
      (mapcat
        #(map
           (fn [gap] (step (if (= piece 'w) 'b 'w) % gap []))
           [[0 1] [0 -1] [1 0] [-1 0] [1 1] [-1 -1] [1 -1] [-1 1]])
        (filter #(= piece (get-in board %)) (mapcat #(map (fn [ele] [% ele]) (range 0 4)) (range 0 4)))))))
