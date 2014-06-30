package com.bobgettys.bigdata;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class Main {

	public static void main(String[] args) throws UnknownHostException {
		//@formatter:off
		try(Cluster cluster = new Cluster.Builder()
		.addContactPoints(InetAddress.getByAddress(new byte[] {127,0,0,1}))
		.build()) {//@formatter:on
			try (Session session = cluster.connect("mykeyspace")) {
				session.execute("SELECT * FROM users WHERE user_id = 1747").forEach(
						(Row row) -> System.out.println(row));
			}
		}

	}
}
