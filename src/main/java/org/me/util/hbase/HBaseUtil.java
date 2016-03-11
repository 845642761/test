package org.me.util.hbase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.io.compress.Compression.Algorithm;

public class HBaseUtil {
	private Connection hbaseConn;

	public HBaseUtil(HashMap<String, String> hm) {
		Configuration conf = HBaseConfiguration.create();
		if(hm != null){
			Iterator<Entry<String, String>> it = hm.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, String> entry = it.next();
				conf.set(entry.getKey(), entry.getValue());
			}
			conf.set("hbase.zookeeper.property.clientPort", "2181");
			conf.set("hbase.zookeeper.quorum", "10.10.8.217");
			conf.set("hbase.rpc.protection", "privacy");
		}
		try {
			hbaseConn = ConnectionFactory.createConnection(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createTable(String tableName, String columDescript) {
		try (Admin admin = hbaseConn.getAdmin()) {
			HTableDescriptor table = new HTableDescriptor(
					TableName.valueOf(tableName));
			table.addFamily(new HColumnDescriptor(columDescript)
					.setCompressionType(Algorithm.SNAPPY));

			if (admin.tableExists(table.getTableName())) {
				admin.disableTable(table.getTableName());
				admin.deleteTable(table.getTableName());
			}
			admin.createTable(table);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
