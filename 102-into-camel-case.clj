(fn [s]
  (let [r (re-seq #"[^-]+" s)]
    (apply str (cons
                 (first r)
                 (map
                   #(apply str (concat [(.toUpperCase (str (first %)))] (rest %)))
                   (rest r))))))