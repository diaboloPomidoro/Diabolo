package TypeOfObjects;

/**
 * Created by Diabolo on 02.04.2017.
 */
public class Relation {
    private int Id;
    private int idPerson;
    private int idCompany;
    private int nodeId;

    public Relation() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    public void setId(String id) {
        int intId = Integer.parseInt(id);
        Id = intId ;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public void setIdPerson(String idPerson) {
        int intIdPerson = Integer.parseInt(idPerson);
        this.idPerson = intIdPerson;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public void setIdCompany(String idCompany) {
        int intIdCompany = Integer.parseInt(idCompany);
        this.idCompany = intIdCompany;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public void setNodeId(String nodeId) {
        int intNodeId = Integer.parseInt(nodeId);
        this.nodeId = intNodeId;
    }

    public String getNodeDescriptio(int nodeId){
        String description = null;
        for(Enums.Nodes e : Enums.Nodes.values()){
            if (nodeId == e.getNodeId()){
                return description = e.getDescription();
            }
        }return "no info";
    }

    @Override
    public String toString() {
        return "Relation{" +
                "Id=" + Id +
                ", idPerson=" + idPerson +
                ", idCompany=" + idCompany +
                ", nodeId=" + nodeId +
                ", nodeDescription=" + getNodeDescriptio(nodeId)+
                '}';
    }
}
