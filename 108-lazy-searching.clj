(fn lazy-search [& colls]
  (let [first-eles (map first colls)]
    (if (every? #(= (first first-eles) %) first-eles)
      (first first-eles)
      (let [sorted-colls (sort-by first colls)]
        (apply lazy-search (cons (rest (first sorted-colls)) (rest sorted-colls)))))))