(fn
          [a b]
          (letfn
            [(step
               [a b]
               (if b
                 (cons
                   a
                   (cons
                     (first b)
                     (step a (next b))))))]
            (drop 1 (step a b))))
