(fn [graph]
  (letfn [(step [current-vertice searched-edge graph]
            (if (= (count searched-edge) (count graph))
              true
              (let [next-edges (filter
                                 #(nil? (some #{%} searched-edge))
                                 (filter #(some #{current-vertice} %) graph))]
                (if (seq next-edges)
                  (true?
                    (some
                      true?
                      (map
                        #(step
                           (first (filter (fn [vertice] (not= vertice current-vertice)) %))
                           (cons % searched-edge)
                           graph)
                        next-edges)))
                  false))))]
    (step (first (flatten graph)) [] graph)))