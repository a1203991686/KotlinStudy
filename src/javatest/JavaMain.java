package javatest;

/**
 * 面试题46. 把数字翻译成字符串
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
class JavaMain {

    private OnClickListener onClickListener;
    private int outterA = 1;

    public void setOnClickListener(OnClickListener a) {
        this.onClickListener = a;
    }

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("1" + i);
            }
        });
        Thread b = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("2" + i);
            }
        });
        Thread c = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("3" + i);
            }
        });
        Thread d = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("4" + i);
            }
        });
        try {
            a.start();
            b.start();
            c.start();
            d.start();
            a.join();
            b.join();
            c.join();
            d.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    void onClick(final int a) {
        int onClickA = 1;
        JavaMain javaMain = new JavaMain();
        javaMain.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println(a);
                System.out.println(outterA);
                System.out.println(onClickA);
            }
        });
    }
}

interface OnClickListener {
    void onClick();
}
