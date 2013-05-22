(fn [roman-numeral]
  (let [value-map {\I 1 \V 5 \X 10 \L 50 \C 100 \D 500 \M 1000}]
    (reduce + (map
                (fn
                  [str]
                  (if (and (> (count str) 1) (< (value-map (first str)) (value-map (second str))))
                    (- (value-map (second str)) (value-map (first str)))
                    (reduce + (map #(value-map %) str))))
                [(first (re-seq #"M*" roman-numeral))
                 (first (re-seq #"[CD][CDM]*" roman-numeral))
                 (first (re-seq #"[XL][XLC]*" roman-numeral))
                 (first (re-seq #"[IV][IVX]*" roman-numeral))]))))
