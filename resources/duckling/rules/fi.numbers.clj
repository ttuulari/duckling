(
  "intersect"
  [(dim :number :grain #(> (:grain %) 1)) (dim :number)] ; grain 1 are taken care of by specific rule
  (compose-numbers %1 %2)

  "intersect (with and)"
  [(dim :number :grain #(> (:grain %) 1)) #"(?i)ja" (dim :number)] ; grain 1 are taken care of by specific rule
  (compose-numbers %1 %3)

 ;;
 ;; Integers
 ;;

  "integer (0..19)"
  #"(?i)(nolla|tyhjä|ei|yksitoista|yksi|kaksitoista|kaksi|kolmetoista|kolme|neljätoista|neljä|viisitoista|viisi|kuusitoista|kuusi|seitsemäntoista|seitsemän|kahdeksantoista|kahdeksan|yhdeksäntoista|yhdeksän)"
  {:dim :number
   :integer true
   :value (get {"nolla" 0 "tyhjä" 0 "ei" 0 "yksi" 1 "kaksi" 2 "kolme" 3 "neljä" 4 "viisi" 5 "kuusi" 6 "seitsemän" 7 "kahdeksan" 8 "yhdeksän" 9 "kymmenen" 10 "yksitoista" 11 "kaksitoista" 12 "kolmetoista" 13 "neljätoista" 14 "viisitoista" 15 "kuusitoista" 16 "seitsemäntoista" 17 "kahdeksantoista" 18 "yhdeksäntoista" 19}
               (-> %1 :groups first .toLowerCase))}

  "kymmenen"
  #"(?i)kymmenen"
  {:dim :number :integer true :value 10 :grain 1}

  "kymmenen"
  #"(?i)kymmentä"
  {:dim :number :integer true :value 10 :grain 1}

  "tusina"
  #"(?i)tusinaa?"
  {:dim :number :integer true :value 12 :grain 1 :grouping true} ;;restrict composition and prevent "2 12"

  "sata"
  #"(?i)sataa?"
  {:dim :number :integer true :value 100 :grain 2}

  "tuhat"
  #"(?i)tuhat(ta)?"
  {:dim :number :integer true :value 1000 :grain 3}

  "miljoona"
  #"(?i)miljoonaa?"
  {:dim :number :integer true :value 1000000 :grain 6}

  "miljardi"
  #"(?i)miljardia?"
  {:dim :number :integer true :value 1000000000 :grain 9}

  "a couple of"
  #"pari"
  {:dim :number :integer true :value 2}

  "few" ; TODO set assumption
  #"muutama"
  {:dim :number :integer true :precision :approximate :value 3}

  "number (20..90)"
  #"(?i)(kaksikymmentä|kolmekymmentä|neljäkymmentä|viisikymmentä|kuusikymmentä|seitsemänkymmentä|kahdeksankymmentä|yhdeksänkymmentä)"
  {:dim :number
   :integer true
   :value (get {"kaksikymmentä" 20 "kolmekymmentä" 30 "neljäkymmentä" 40 "viisikymmentä" 50 "kuusikymmentä" 60
                "seitsemänkymmentä" 70 "kahdeksankymmentä" 80 "yhdeksänkymmentä" 90}
             (-> %1 :groups first .toLowerCase))
   :grain 1}

   "number (21..29 31..39 41..49 51..59 61..69 71..79 81..89 91..99)"
   #"(?i)((kaksikymmentä|kolmekymmentä|neljäkymmentä|viisikymmentä|kuusikymmentä|seitsemänkymmentä|kahdeksankymmentä|yhdeksänkymmentä)(yksi|kaksi|kolme|neljä|viisi|kuusi|seitsemän|kahdeksan|yhdeksän))"
   {:dim :number
    :integer true
    :value (get {"kahdeksankymmentäkaksi" 82 "viisikymmentäseitsemän" 57 "yhdeksänkymmentäyhdeksän" 99 "neljäkymmentäyksi" 41 "viisikymmentäkaksi" 52 "neljäkymmentäseitsemän" 47 "kaksikymmentäkolme" 23 "kuusikymmentäkaksi" 62 "seitsemänkymmentäviisi" 75 "kuusikymmentäkuusi" 66 "kahdeksankymmentäkahdeksan" 88 "kahdeksankymmentäneljä" 84 "neljäkymmentäkaksi" 42 "kaksikymmentäviisi" 25 "seitsemänkymmentäkuusi" 76 "kahdeksankymmentäseitsemän" 87 "seitsemänkymmentäyhdeksän" 79 "kaksikymmentäneljä" 24 "neljäkymmentäkahdeksan" 48 "yhdeksänkymmentäneljä" 94 "viisikymmentäyksi" 51 "seitsemänkymmentäkaksi" 72 "kolmekymmentäneljä" 34 "kaksikymmentäyhdeksän" 29 "seitsemänkymmentäneljä" 74 "kolmekymmentäyksi" 31 "kuusikymmentäkolme" 63 "kuusikymmentäviisi" 65 "viisikymmentäkuusi" 56 "neljäkymmentäkolme" 43 "kuusikymmentäyhdeksän" 69 "kahdeksankymmentäyhdeksän" 89 "viisikymmentäviisi" 55 "yhdeksänkymmentäyksi" 91 "kolmekymmentäyhdeksän" 39 " yhdeksänkymmentäseitsemän" 97 "kuusikymmentäseitsemän" 67 "kolmekymmentäkuusi" 36 "yhdeksänkymmentäkolme" 93 "viisikymmentäkahdeksan" 58 "yhdeksänkymmentäkaksi" 92 "neljäkymmentäkuusi" 46 "kaksikymmentäkuusi" 26 "kaksikymmentäkahdeksan" 28 "kolmekymmentäkaksi" 32 "seitsemänkymmentäseitsemän" 77 "kaksikymmentäyksi" 21 "seitsemänkymmentäkolme" 73 "neljäkymmentäyhdeksän" 49 "kolmekymmentäkahdeksan" 38 "yhdeksänkymmentäkahdeksan" 98 "kuusikymmentäyksi" 61 "kolmekymmentäkolme" 33 "viisikymmentäkolme" 53 "kuusikymmentäneljä" 64 "seitsemänkymmentäkahdeksan" 78 "neljäkymmentäneljä" 44 "kuusikymmentäkahdeksan" 68 "yhdeksänkymmentäkuusi" 96 "neljäkymmentäviisi" 45 "kahdeksankymmentäyksi" 81 "kolmekymmentäseitsemän" 37 "kolmekymmentäviisi" 35 "viisikymmentäneljä" 54 "viisikymmentäyhdeksän" 59 "kaksikymmentäseitsemän" 27 "yhdeksänkymmentäviisi" 95 "kahdeksankymmentäkolme" 83 "kahdeksankymmentäviisi" 85 "seitsemänkymmentäyksi" 71 "kahdeksankymmentäkuusi" 86 "kaksikymmentäkaksi" 22}
               (-> %1 :groups first .toLowerCase))}

  "integer 21..99"
  [(integer 10 90 #(#{20 30 40 50 60 70 80 90} (:value %))) (integer 1 9)]
  {:dim :number
   :integer true
   :value (+ (:value %1) (:value %2))}

  "integer (numeric)"
  #"(\d{1,18})"
  {:dim :number
   :integer true
   :value (Long/parseLong (first (:groups %1)))}

  "integer with thousands separator ,"
  #"(\d{1,3}(,\d\d\d){1,5})"
  {:dim :number
   :integer true
   :value (-> (:groups %1)
            first
            (clojure.string/replace #"," "")
            Long/parseLong)}

  ; composition
  "special composition for missing hundreds like in one twenty two"
  [(integer 1 9) (integer 10 99)] ; grain 1 are taken care of by specific rule
  {:dim :number
   :integer true
   :value (+ (* (:value %1) 100) (:value %2))
   :grain 1}


  "number dozen"
  [(integer 1 10) (dim :number #(:grouping %))]
  {:dim :number
   :integer true
   :value (* (:value %1) (:value %2))
   :grain (:grain %2)}


  "number hundreds"
  [(integer 1 99) (integer 100 100)]
  {:dim :number
   :integer true
   :value (* (:value %1) (:value %2))
   :grain (:grain %2)}

  "number thousands"
  [(integer 1 999) (integer 1000 1000)]
  {:dim :number
   :integer true
   :value (* (:value %1) (:value %2))
   :grain (:grain %2)}

  "number millions"
  [(integer 1 99) (integer 1000000 1000000)]
  {:dim :number
   :integer true
   :value (* (:value %1) (:value %2))
   :grain (:grain %2)}

  ;;
  ;; Decimals
  ;;

  "decimal number"
  #"(\d*\.\d+)"
  {:dim :number
   :value (Double/parseDouble (first (:groups %1)))}

  "number dot number"
  [(dim :number #(not (:number-prefixed %))) #"(?i)piste" (dim :number #(not (:number-suffixed %)))]
  {:dim :number
   :value (+ (* 0.1 (:value %3)) (:value %1))}


  "decimal with thousands separator"
  #"(\d+(,\d\d\d)+\.\d+)"
  {:dim :number
   :value (-> (:groups %1)
            first
            (clojure.string/replace #"," "")
            Double/parseDouble)}

  ;; negative number
  "numbers prefix with -, negative or minus"
  [#"(?i)-|miinus\s?|negatiivinen\s?" (dim :number #(not (:number-prefixed %)))]
  (let [multiplier -1
        value      (* (:value %2) multiplier)
        int?       (zero? (mod value 1)) ; often true, but we could have 1.1111K
        value      (if int? (long value) value)] ; cleaner if we have the right type
    (assoc %2 :value value
              :integer int?
              :number-prefixed true)) ; prevent "- -3km" to be 3 billions


  ;; suffixes

  ; note that we check for a space-like char after the M, K or G
  ; to avoid matching 3 Mandarins
  "numbers suffixes (K, M, G)"
  [(dim :number #(not (:number-suffixed %))) #"(?i)([kmg])(?=[\W\$€]|$)"]
  (let [multiplier (get {"k" 1000 "m" 1000000 "g" 1000000000}
                        (-> %2 :groups first .toLowerCase))
        value      (* (:value %1) multiplier)
        int?       (zero? (mod value 1)) ; often true, but we could have 1.1111K
        value      (if int? (long value) value)] ; cleaner if we have the right type
    (assoc %1 :value value
              :integer int?
              :number-suffixed true)) ; prevent "3km" to be 3 billions

  ;;
  ;; Ordinal numbers
  ;;

  "ordinals (first..19th)"
  #"(?i)(ensimmäinen|toinen|kolmas|neljäs|viides|kuudes|seitsemäs|kahdeksas|yhdeksäs|kymmenes|yhdestoista|kahdestoista|kolmastoista|neljästoista|viidestoista|kuudestoista|seitsemästoista|kahdeksastoista|yhdeksästoista|kahdeskymmenes)"
  {:dim :ordinal
   :value (get {"ensimmäinen" 1  "toinen" 2 "kolmas" 3 "neljäs" 4 "viides" 5 "kuudes" 6 "seitsemäs" 7 "kahdeksas" 8 "yhdeksäs" 9 "kymmenes" 10 "yhdestoista" 11 "kahdestoista" 12 "kolmastoista" 13 "neljästoista" 14 "viidestoista" 15 "kuudestoista" 16 "seitsemästoista" 17 "kahdeksastoista" 18 "yhdeksästoista" 19 "kahdeskymmenes" 20}
               (-> %1 :groups first .toLowerCase))}

 "ordinal (digits)"
  #"0*(\d+)\."
  {:dim :ordinal
   :value (read-string (first (:groups %1)))}  ; read-string not the safest
)
