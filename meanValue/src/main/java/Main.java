public class Main implements Runnable {
    int[] array = new int[20];
    int meanValue = 10;
    int meanValue1 = 10;
    public int sumValue = 0;
    public int countValue = 0;

    @Override
    public void run() {
        runSimulation();
    }

    public void runSimulation() {
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();

        for (int i = 1; i <= 1000; i++) {
            meanValue = 10;
            for (int j = 0; j < 10; j++) {
                int random = (int) (Math.random() * 2);

                if (random == 0) {
                    decrementAndWrite(meanValue);
                    meanValue--;
                } else if (random == 1) {
                    incrementAndWrite(meanValue);
                    meanValue++;
                }
            }
        }

        for (int i = 1; i <= 1000; i++) {
            meanValue1 = 10;
            for (int j = 0; j < 10; j++) {
                int random = (int) (Math.random() * 2);
                if (random == 0) {
                    decrementAndWrite(meanValue1);
                    meanValue1--;
                } else if (random == 1) {
                    incrementAndWrite(meanValue1);
                    meanValue1++;
                }
            }
        }
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(i + " : " + array[i]);
            sumValue = sumValue + array[i];
        }
    }

    public synchronized void incrementAndWrite(int value) {
        value = value + 1;
        if (value > 19 || value < 0)
            value = 19;
        writeToArr(value);
    }

    public synchronized void decrementAndWrite(int value) {
        value = value - 1;
        if (value < 0)
            value = 0;
        writeToArr(value);
    }

    public synchronized void writeToArr(int value) {
        if (value < 0 || value > 19) {
            double randomNumber = (Math.random() * 20);
            int randomIndex = (int) randomNumber;
            array[randomIndex] = array[randomIndex] + 1;
        }
        array[value] = array[value] + 1;
        countValue++;
    }
}