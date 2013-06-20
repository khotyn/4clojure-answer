(fn [algebra]
  (letfn [(union [s1 s2]
            (set (filter (complement nil?) (map #(if (s1 %) %) s2))))
          (step [algebra]
            (let [r (set (flatten (map
                                    (fn [line]
                                      (let [m (map
                                                #(set (conj
                                                        (remove #{%} line)
                                                        (case (str %)
                                                          "a" 'A
                                                          "A" 'a
                                                          "b" 'B
                                                          "B" 'b
                                                          "c" 'C
                                                          "C" 'c
                                                          "d" 'D
                                                          "D" 'd)))
                                                line)
                                            s (filter (complement nil?) (map #(if (algebra %) (union line %)) m))]
                                        (if (seq s) s line)))
                                    algebra)))]
              (if (not= r algebra) (step r) algebra)))
          (power-set [s]
            (set (reduce #(concat %1 (map (fn [i] (set (conj i %2))) %1)) #{#{}} s)))]
    (let [ps (power-set (step algebra))]
      (apply
        (partial min-key count)
        (filter
          (complement nil?)
          (map
            (fn [s]
              (let [r (set (mapcat (fn [e] (filter (fn [line] (every? #(line %) e)) algebra)) s))]
                (if (= r algebra) s))
              )
            ps))))))
