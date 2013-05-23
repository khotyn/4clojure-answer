(fn [graph]
  (let [vertices (set (apply concat graph))]
    (letfn [(vertex-connectness [vertex searched-vertex graph]
              (let [adjacent-vertices (filter #(not (searched-vertex %)) (apply concat (filter #(some #{vertex} %) graph)))]
                (if (seq adjacent-vertices)
                  (set (mapcat #(vertex-connectness % (set (cons % searched-vertex)) graph) adjacent-vertices))
                  searched-vertex)))]
      (every? #(= vertices (vertex-connectness % #{%} graph)) vertices))))