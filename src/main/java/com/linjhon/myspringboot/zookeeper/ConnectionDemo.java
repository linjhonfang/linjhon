package com.linjhon.myspringboot.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 *
 */
public class ConnectionDemo {

    public static void main(String[] args) {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zooKeeper =
                    new ZooKeeper("101.201.66.32:12181",
                            4000, new Watcher() {
                        @Override
                        public void process(WatchedEvent event) {
                            if (Event.KeeperState.SyncConnected == event.getState()) {
                                //如果收到了服务端的响应事件，连接成功
                                countDownLatch.countDown();
                            }
                        }
                    });
            countDownLatch.await();
            System.out.println("result of connecting:" + zooKeeper.getState());//CONNECTED

            //添加节点
            Stat exists = zooKeeper.exists("/zk-persis-flj", null);
            if (exists == null) {
                String creatRs = zooKeeper.create("/zk-persis-flj", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                Thread.sleep(3000);
                System.out.println("result of creating node:" + creatRs);
            }
            Stat stat = new Stat();

            //得到当前节点的值
            byte[] bytes = zooKeeper.getData("/zk-persis-flj", null, stat);
            System.out.println("value of node:" + new String(bytes));

            //修改节点值
            zooKeeper.setData("/zk-persis-flj", "1".getBytes(), stat.getVersion());

            //得到当前节点的值
            byte[] bytes1 = zooKeeper.getData("/zk-persis-flj", null, stat);
            System.out.println("value of node:" + new String(bytes1));

//            zooKeeper.delete("/zk-persis-flj", stat.getVersion());

            zooKeeper.close();

            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
