package transfer.service;


import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import net.anotheria.moskito.aop.annotation.Monitor;
import transfer.acid.TransferAcid;
import transfer.optimistic.TransferOptimistic;
import transfer.pessimistic.TransferPessimisticWait;
import transfer.utils.DBUtils;

@Path("/transfer")
@Monitor
public class TransferRemoteFacade {
	
	@GET
	@Path("/acid")
	public void acidTransfer(@QueryParam("from") String from, 
			@QueryParam("to") String to, @QueryParam("amount") int amount) {
		try(Connection conn = DBUtils.getConnection()) {
			TransferAcid transfer = new TransferAcid(conn);
			transfer.transfer(from, to, amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	@GET
	@Path("/optimistic")
	public void optimisticTransfer(@QueryParam("from") String from, 
			@QueryParam("to") String to, @QueryParam("amount") int amount) {
		try(Connection conn = DBUtils.getConnection()) {
			TransferOptimistic transfer = new TransferOptimistic(conn);
			transfer.transfer(from, to, amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/pessimistic")
	public void pessimisticTransfer(@QueryParam("from") String from, 
			@QueryParam("to") String to, @QueryParam("amount") int amount) {
		try(Connection conn = DBUtils.getConnection()) {
			TransferPessimisticWait transfer = new TransferPessimisticWait(conn);
			transfer.transfer(from, to, amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
