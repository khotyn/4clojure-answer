(fn [board]
  (map #(apply str %) (map
                        (fn [sub-board]
                          (apply
                            (partial
                              map
                              (fn [first-row second-row last-row]
                                (case (count (filter #{\#} (concat first-row last-row [(first second-row) (last second-row)])))
                                  3 \#
                                  2 (second second-row)
                                  \space)))
                            (map #(partition 3 1 (concat [\space] % [\space])) sub-board)))
                        (partition 3 1 (concat ["      "] board ["      "])))))