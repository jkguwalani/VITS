package dao;

import enums.TableName;

public class DAOFactory {

	public static CommonDAO create(TableName TABLENAME) {

		switch (TABLENAME) {
		case User_Mstr:
			return new UserDAOImpl();
		case Company_Mstr:
			return new CompanyDAOImpl();
		case Scheme_Mstr:
			return new SchemeDAOImpl();
		case Agent_Mstr:
			return new AgentDAOImpl();
		case Policy_Mstr:
			return new PolicyDAOImpl();
		default:
			return new CommonDAOImpl();

		}
	}
}
