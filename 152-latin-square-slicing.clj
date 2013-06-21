(fn [square]
  (letfn [(rotate [s]
            (if (every? seq s) (cons (map first s) (rotate (map next s)))))
          (is-latin-square? [s]
            (let [eles (set (flatten s))]
              (if (eles \space)
                false
                (if
                  (= (count s) (count eles))
                  (and (every? #(= (set %) eles) s) (every? #(= (set %) eles) (rotate s)))
                  false))))
          (slice [s]
            (set (mapcat
                   (fn [n]
                     (mapcat
                       #(partition n (apply interleave (map (fn [l] (partition n 1 l)) %)))
                       (partition n 1 s)))
                   (range 2 (inc (count s))))))
          (trans [s]
            (let [max-len (apply max (map count s))]
              (letfn [(trans-step [transed-s rest-s]
                        (let [first-line (first rest-s)]
                          (if (seq first-line)
                            (if (= max-len (count first-line))
                              (trans-step (cons first-line transed-s) (next rest-s))
                              (mapcat
                                (fn [pos]
                                  (trans-step
                                    (cons
                                      (concat (concat (repeat pos \space) first-line) (repeat (- max-len (+ pos (count first-line))) \space))
                                      transed-s)
                                    (next rest-s)))
                                (range 0 (inc (- max-len (count first-line))))))
                            transed-s)))]
                (set (partition (count s) (trans-step [] s))))))]
    (apply merge (map
                   (fn [entry]
                     (let [c (count (filter is-latin-square? (val entry)))]
                       (if (pos? c) {(key entry) c} {})))
                   (group-by count (set (mapcat #(slice %) (trans square))))))))
