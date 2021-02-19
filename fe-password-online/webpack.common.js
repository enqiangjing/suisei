const path = require('path');
const {
    CleanWebpackPlugin
} = require('clean-webpack-plugin');
const VueLoaderPlugin = require('vue-loader/lib/plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');

module.exports = {
    entry: {
        app: './src/main.js',
    },
    plugins: [
        // 对于 CleanWebpackPlugin 的 v2 versions 以下版本，使用 new CleanWebpackPlugin(['dist/*'])
        new CleanWebpackPlugin(),
        new HtmlWebpackPlugin({
            title: '在线密码中心',
            template: './public/index.html', // 源模板文件
            filename: './index.html', // 输出文件【注意：这里的根路径是module.exports.output.path】
            showErrors: true,
            inject: 'body',
        }),
        new CopyWebpackPlugin({
            patterns: [{
                from: "public/favicon.ico",
                to: "favicon.ico"
            },],
        }),
        new VueLoaderPlugin(),
    ],
    output: {
        filename: 'main.js',
        path: path.resolve(__dirname, 'dist'),
    },
    module: {
        rules: [{
            test: /\.css$/,
            use: ['vue-style-loader', {
                loader: 'css-loader',
                options: {
                    esModule: false
                }
            }],
        },
        {
            test: /\.(png|svg|jpg|jpeg|gif)$/i,
            type: 'asset/resource',
        },
        {
            test: /\.vue$/,
            loader: 'vue-loader'
        },
        {
            test: /\.less$/,
            use: [
                'vue-style-loader',
                {
                    loader: 'css-loader',
                    options: {
                        esModule: false
                    }
                },
                'less-loader'
            ]
        },
        ],
    },
};