(fn
          [a b]
          (letfn
            [(step
               [a b]
               (if (and a b)
                 (cons
                   (first a)
                   (cons
                     (first b)
                     (step (next a) (next b))))))]
            (step a b)))
