(fn [form]
  (letfn [(step [s]
            (let [formulars (re-seq #"\([^\(\)]*\)" s)]
              (if (seq formulars)
                (let [formulars-results (map
                                          (fn [formular]
                                            (let [formular-seq (re-seq #"[\+\-\*/0-9]+" formular)]
                                              (apply
                                                (case (first formular-seq)
                                                  "+" +
                                                  "-" -
                                                  "*" *
                                                  "/" /)
                                                (map #(Integer/parseInt %) (rest formular-seq)))
                                              ))
                                          formulars)]
                  (step (reduce #(.replace %1 (key %2) (str (val %2))) s (apply assoc {} (interleave formulars formulars-results)))))
                (Integer/parseInt s))))]
    (fn [m]
      (let [form-str (str form)]
        (step (reduce #(.replace %1 (str (key %2)) (str (val %2))) form-str m))))))