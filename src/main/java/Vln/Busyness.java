package Vln;

public enum Busyness {
        VERY_HIGH(1.6),
        HIGH(1.4),
        INCREASED(1.2),
        NORMAL(1.0);

        private final double multiplierForBusyness;

        Busyness(double multiplierForBusyness){
            this.multiplierForBusyness = multiplierForBusyness;
        }

        public double getMultiplierForBusyness() {
            return multiplierForBusyness;
        }
    }

