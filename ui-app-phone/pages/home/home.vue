<template>
	<view class="home">
		<view class="primary-bg cc-display nav">
			<view class="search ec-display">
				<LoginInput type="search" class="input" v-model="searchInupt" placeholder="请输入搜索值" />
			</view>
			<view class="logo cc-display">
				<image src="/static/img/home/mlogo.svg" alt="" @click="fnGetAccountList" />
			</view>
		</view>
		<MainList :msgList="accountList"></MainList>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				sonMenu: false,
				searchInupt: "",
				accountList: [],
				accountListCopy: [],
			};
		},
		created() {
			this.fnGetAccountList();
			this.accountSearch = _.debounce(this.fnSearchInCurrent, 500);
		},
		methods: {
			// 账户信息查询
			fnGetAccountList() {
				if (this.$store.state.privateKey === "") {
					uni.showToast({
						title: '私钥未载入！',
						icon: 'none',
						duration: 2000,
					});
					return;
				}
				this.$rsa.setPrivateKey(
					"-----BEGIN RSA PRIVATE KEY-----" +
					this.$store.state.privateKey +
					"-----END RSA PRIVATE KEY-----"
				);
				// 查询加密数据列表
				uni.request({
					url: this.$baseUrl + 'api/getListLike', //仅为示例，并非真实接口地址。
					method: 'POST',
					data: {
						userName: this.$store.state.userName,
					},
					header: {
						'custom-header': 'uni-app-suisei' //自定义请求头信息
					},
					success: (res) => {
						if (res.data.errCode === 'success') {
							// 数据解密
							this.accountList = res.data.data.map((e) => {
								return {
									...e,
									account: this.$rsa.decrypt(e.account),
									extra: this.$rsa.decrypt(e.extra),
									password: this.$rsa.decrypt(e.password),
									systemName: this.$rsa.decrypt(e.systemName),
								};
							});
							this.accountListCopy = this.accountList;
							uni.showToast({
								title: '查询成功！',
								icon: 'none',
								duration: 2000,
							});
							return;
						}
						uni.showToast({
							title: res.data,
							icon: 'none',
							duration: 2000,
						});
					}
				});
			},
			// 搜索
			fnSearchInCurrent() {
				// 页面内数据搜索
				this.accountList = this.accountListCopy.filter((x) => {
					let flag = false;
					for (let i in x) {
						if (String(x[i]).includes(this.searchInupt)) {
							flag = true;
							break;
						}
					}
					return flag;
				});
			},
		},
		watch: {
		    // 输入变化后进行搜索
		    searchInupt(newVal, oldVal) {
		      if (newVal !== oldVal && newVal.trim() !== "")
		        return this.accountSearch();
		      this.accountList = this.accountListCopy;
		    },
		  },
	}
</script>

<style lang="less" scoped>
	// 菜单按钮背景
	@menu-bg: rgb(67, 148, 253);

	.home {
		position: relative;
		height: 100%;
		width: 100%;
		background: url(/static/logo.png) no-repeat top center;
		overflow-y: auto;

		.nav {
			width: 100%;
			height: 60px;
			position: relative;
			position: sticky;
			top: 0;
			z-index: 1100;

			.logo {
				height: 100%;
				width: 20%;

				image {
					width: 40px;
					height: 40px;
				}
			}

			.search {
				width: 80%;
				height: 100%;

				.input {
					width: 90%;
					height: 45px;
					background-color: #fff;
				}
			}
		}
	}
</style>
