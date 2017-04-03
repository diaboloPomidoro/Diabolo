package TypeOfObjects;

/**
 * Created by Diabolo on 02.04.2017.
 */

public class Enums {
    public enum EntityType {
        PERSON(5,";"),
        COMPANY(4,";"),
        RELATION(4,";"),
        MISTAKE(0,"");

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
        OWNER(100,"owner"),
        PRESIDENT(200,"president"),
        MEMBER_OF_THE_BOARD(300,"member of the board");

        private final int nodeId;
        private final String description;

        Nodes(int nodeId, String description) {
            this.nodeId = nodeId;
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public int getNodeId() {
            return nodeId;
        }
    }


}