package TypeOfObjects;

/**
 * Created by Diabolo on 02.04.2017.
 */

public class Enums {
    public enum EntityType {
        PERSON(5,";"),
        COMPANY(4,";"),
        RELATION(4,";");

        private final int COLLUMNS_QUANTITY;
        private final String DELIMITER;

        EntityType(int COLLUMNS_QUANTITY, String DELIMITER) {
            this.COLLUMNS_QUANTITY = COLLUMNS_QUANTITY;
            this.DELIMITER = DELIMITER;
        }

        public int getCOLLUMNS_QUANTITY() {
            return COLLUMNS_QUANTITY;
        }

        public String getDELIMITER() {
            return DELIMITER;
        }
    }

    public enum Nodes {
        OWNER(100),
        PRESIDENT(200),
        MEMBER_OF_THE_BOARD(300);

        private final int nodeId;

        Nodes(int nodeId) {
            this.nodeId = nodeId;
        }

        public int getNodeId() {
            return nodeId;
        }
    }
}